package ipv4


/**
 * IPv4 address checker function that determines whether a given string is a valid IPv4 address.
 * @param ip String Represent Ip address version 4
 * @sample isValidIPv4Sample
 * @return True once is valid
 */

fun isValidIpAddressVersion4(ip: String): Boolean {
    if (ip.isEmpty()) return false
    if (!checkIpAddressNotContainSpecialCharacterValidation(ip)) return false
    if (!checkSegmentsInRangeValidation(ip)) return false
    if (!checkNumberOfSegmentsValidation(ip)) return false
    if (!checkNumberOfDotsValidation(ip)) return false
    if(checkSegmentsLeadingByZeroValidation(ip)) return false
    return checkIpAddressPattern(ip)
}

fun checkIpAddressNotContainSpecialCharacterValidation(ip: String) = ip.matches(Regex("^[0-9.]+\$"))

fun checkSegmentsInRangeValidation(ip: String): Boolean {
    val numbers = convertIpAddressToList(ip)
    val checkRange = numbers.filter { it in 0..255 }
    return numbers.size == checkRange.size
}
fun checkNumberOfSegmentsValidation(ip: String):Boolean{
    val numbers = convertIpAddressToList(ip)
    return numbers.size == 4
}

fun checkNumberOfDotsValidation(ip: String) = ip.count{it == '.'} == 3

fun checkSegmentsLeadingByZeroValidation(ip: String):Boolean {
    val numbers = ip.split(".")
    numbers.forEach { number ->
        if (number.length>=2) {
            val checkZeroAtStartOfSegment = number[0] == '0'
            if (checkZeroAtStartOfSegment)
                return true
        }
    }
    return false
}

fun checkIpAddressPattern(ip: String):Boolean {
    val stack = mutableListOf<Char>()
    for (char in ip){
        if (char.isDigit()){
            stack.add(char)
        }else{
            if (stack.isEmpty())
                return false
            stack.removeAll { it.isDigit() }
        }
    }
    val checkStack = stack.filter { it.isDigit() }
    return checkStack.size == stack.size && stack.size <= 3 && stack.size >=1
}


fun convertIpAddressToList(ip: String):List<Int> =  ip.split(".").mapNotNull { it.toIntOrNull() }.toList()


fun isValidIPv4Sample() {
    val ip = "192.168.1.1"
    isValidIpAddressVersion4(ip)
}