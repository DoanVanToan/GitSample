package framgia.com.gitsample.extension

fun IntArray.containsOnly(num: Int): Boolean = filter { it == num }.isNotEmpty()