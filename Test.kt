operator fun Int.not(): Boolean = when {
		this == 0 -> true
		this == 1 -> false
		else -> false
	}

operator fun String.not(): Boolean = this.isEmpty()

operator fun Array<*>.not(): Boolean = false
