//package kotlinx.cli.examples

import kotlinx.cli.*

fun main(args: Array<String>) {
    // Define commandName-line interface
    val cli = CommandLineInterface("Example1")
    val integers by cli.positionalArgumentsList("N+", "Integers", minArgs = 1)
    val radix by cli.flagValueArgument("-r", "radix", "Input numbers radix", 10) { it.toInt() }
    val sum by cli.flagArgument("--sum", "Print sum")
    val max by cli.flagArgument("--max", "Print max")
    val min by cli.flagArgument("--min", "Print min")

    // Parse arguments or exit
    try {
        cli.parse(args)
        val ints = integers.map { it.toInt(radix) }
        println("Args: ${args.asList()}")
        println("Integers: $ints")
        if (sum) println("Sum: ${ints.sum()}")
        if (max) println("Max: ${ints.max()}")
        if (min) println("Min: ${ints.min()}")
    } catch (e: Exception){

    }
}
