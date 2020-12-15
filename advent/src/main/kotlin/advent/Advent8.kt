package advent

import java.lang.IllegalStateException

// shades of 2019 right here. last year i did it with a redux-style solution.
// this year, i'm exploring forming a domain-specific language.
class Cpu {
    private var state: CpuState = CpuState(pc = 0, accumulator = 0)
    private var instructions: List<Instruction> = emptyList()

    val nop = Op.Nop(this)
    val acc = Op.Acc(this)
    val jmp = Op.Jmp(this)

    sealed class Op(private val cpu: Cpu) {
        operator fun plus(i: Int) {
            cpu.instructions = cpu.instructions + Instruction(this, i)
        }

        operator fun minus(i: Int) = plus(-i)

        class Nop(cpu: Cpu) : Op(cpu)
        class Acc(cpu: Cpu) : Op(cpu)
        class Jmp(cpu: Cpu) : Op(cpu)
    }

    fun step(steps: Int): Cpu {
        for (i in 1..steps) perform(instructions[state.pc])
        return this
    }

    fun runUntilFirstLoop(): Cpu = run { !ranToLoop() }

    private fun ranToLoop() = state.previousPcs.contains(state.pc)

    private fun run(filter: () -> Boolean = { true }): Cpu {
        while (state.pc < instructions.size && filter()) {
            if (state.previousPcs.size > 10000) {
                throw IllegalStateException("infinite loop; previous PCs: ${state.previousPcs}")
            }
            perform(instructions[state.pc])
        }
        return this
    }

    private fun perform(command: Pair<Op, Int>) {
        state = when (command.first) {
            is Op.Nop -> state.copy(pc = state.pc + 1)
            is Op.Acc -> state.copy(
                pc = state.pc + 1,
                accumulator = state.accumulator + command.second
            )
            is Op.Jmp -> state.copy(pc = state.pc + command.second)
        }.copy(previousPcs = state.previousPcs + state.pc)
    }

    fun inspect(inspectFn: CpuState.() -> Unit) = inspectFn(this.state)

    // classic part two hack
    fun mutateToRemoveLoop(): List<Cpu> = instructions
        .mapIndexed { idx, instruction ->
            when (instruction.first) {
                is Op.Nop -> withOverride(idx, jmp)
                is Op.Jmp -> withOverride(idx, nop)
                else -> this
            }
        }
        .filter { !it.runUntilFirstLoop().ranToLoop() }

    private fun withOverride(idx: Int, override: Op): Cpu = Cpu(
        instructions = instructions.mapIndexed { current, original ->
            if (current == idx) {
                Instruction(override, original.second)
            } else original
        })

    data class CpuState(
        val pc: Int,
        val accumulator: Int,
        val previousPcs: List<Int> = emptyList()
    )

    constructor(runtime: Cpu.() -> Unit) {
        runtime()
    }

    constructor(instructions: List<Instruction>) {
        this.instructions = instructions
    }
}

typealias Instruction = Pair<Cpu.Op, Int>
