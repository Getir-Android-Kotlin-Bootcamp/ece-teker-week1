fun main() {

    //SAYFA 9 PRINT
    printPageStart(9)
    print("Greetings ")
    print("Patika :)")
    println()
    println("Greetings Patika :)")
    println(1234)
    printPageEnd(9)

    //SAYFA 10 FUNCTIONS
    printPageStart(10)
    println("135 minutes= ${minsToHours(135)}")
    println("2 hours= ${hoursToMins(2)}")
    printMinsToHours(140)
    printPageEnd(10)

    //SAYFA 11
    val actorName: String = "Neil Patrick"
    val actorLastName = "Harris"
    val actorBirthYear: Int
    actorBirthYear = 1973
    var numOfRoles = 50

    fun newRole(): Int {
        numOfRoles++
        return numOfRoles
    }

    printPageStart(11)
    println(
        """${actorName} ${actorLastName} (Born in ${actorBirthYear}) just got a new role! 
          He used to have ${numOfRoles} roles. That makes his number of roles ${newRole()}!"""
    )
    printPageEnd(11)

    //SAYFA 12 CLASSES AND INSTANCES
    printPageStart(12)
    val device = Device()
    device.turnOn()
    device.turnOff()

    val telephone = Telephone("La La La ")
    println("New phone's ringtone sounds like ${telephone.ring}")
    println("\n(Same example with open class Device2)")

    //created instance with open class
    val telephone2 = Telephone2()
    telephone2.turnOn()
    telephone2.turnOff()
    printPageEnd(12)

    //SAYFA 13
    printPageStart(13)
    val singer = Singer("Adele", 35)
    singer.sayName()
    println("- ${singer.name}, can you sing Rolling in the Deep?")
    singer.sing("Rolling in the Deep")
    println("- ${singer.name}, can you sing Baby by Justin Bieber?")
    singer.sing("Baby")
    printPageEnd(13)

    //SAYFA 14 STRING
    printPageStart(14)
    var age = 21
    val s1 = "I am $age years old"

    age = 22
    val s2 = "${s1.replace("am", "was")}, but now I am $age"
    println(s2)
    printPageEnd(14)

    //SAYFA 15 KOSULLU IFADELER
    //if else'ler isEven ve isOdd functionlarinda kullanildi line548 ve line557
    printPageStart(15)
    println(isEven(4))
    println(isOdd(5))
    printPageEnd(15)

    //SAYFA 16 FOR DONGUSU
    val family =
        listOf(Person("Haley", 20), Person("Luke", 16), Person("Alex", 17), Singer("Phil", 32), Person("Claire", 30))

    printPageStart(16)
    println("This family consists of:")
    for (person in family) {
        print("${person.name} ")
    }

    println("\n\nThe singer of the family:")
    for (person in family) {
        if (person is Singer) println(person.name)
    }

    val sortedByName = family.sortedBy { it.name }
    println("\nIf we sort the family by name we get:")
    for (person in sortedByName) {
        print("${person.name} ")
    }
    println()
    printPageEnd(16)

    //SAYFA 17 WHILE DONGUSU
    //while loop line565'teki greetAll() icerisinde kullanilmistir
    printPageStart(17)
    greetAll(family)
    printPageEnd(17)

    //SAYFA 18 WHEN KULLANIMI
    printPageStart(18)
    println("Describe your chores.")
    for (person in family) {
        when (person.name) {
            "Alex" -> person.doChore("Dishes")
            "Haley" -> person.doChore("Cleaning")
            "Luke" -> person.doChore("Laundry")
            "Phil" -> person.doChore("Shopping")
            "Claire" -> person.doChore("Cooking")
            else -> println("I don't have a chore")
        }
    }
    printPageEnd(18)

    //SAYFA 19 RANGES
    printPageStart(19)
    //the family goes to a club where only people who are between the ages of 18 and 30 allowed
    var clubList = listOf<Person>()
    for (person in family) {
        if (person.age in 18..30) {
            println("${person.name} (${person.age}), you can go into the club")
            clubList = clubList + person
        } else {
            println("${person.name} (${person.age}), you are not allowed into the club")
        }
    }

    //someone gave money to Haley and Claire so that they can get drinks in the club
    for (person in clubList) {
        person.earnMoney(20)
    }
    var totalMoney = 0
    for (person in clubList) {
        totalMoney += person.money
    }

    println("\n- Can we get a drink?")
    //all the drinks in the club are between $75 and $80. and there is no change at the register
    if (totalMoney !in 75..80) {
        //money is not enough
        if (totalMoney < 75) {
            println("Sorry ladies. You only have $$totalMoney")
        } else {
            println("Sorry we don't have change")
        }
    }

    print("However, I'll give you a free drink if you can spell your name backwards!\n- ")
    for (i in (clubList[0].name).length - 1 downTo 0) {
        print("${(clubList[0].name)[i].uppercase()} ")
    }

    print("\nCan you also try to say the alphabet skipping one letter every time?\n- ")
    for (letter in 'a'..'z' step 2) print("${letter.uppercase()} ")
    println("\nOkay that is enough! There you go.")
    printPageEnd(19)

    //SAYFA 20 KOLEKSIYONLAR
    val songs = listOf("Skyfall", "Rolling in the Deep", "21", "Rumor Has It")
    printPageStart(20)
    println(songs.sortedBy { it })
    println(songs.filter { it.startsWith("R") })
    songs.forEach { println(it.uppercase()) }
    println(songs.map { it.lowercase() })
    printPageEnd(20)

    //SAYFA 21 NULL CHECK
    var strList: List<String?> = listOf("Rihanna", "Drake", null, "Beyonce")
    printPageStart(21)
    for (person in strList) person?.let { println("Hello $person") }
    printPageEnd(21)

    //SAYFA 22 TYPE CHECK
    printPageStart(22)
    for (person in family) {
        if (person is Singer) person.sing("Rolling in the Deep")
    }

    //if telephone is a device and it has a ringtone, play the ringtone
    if (telephone2 is Device2 &&
        telephone2.ringtone.isNotEmpty()
    ) {
        println("Phone is ringing")
        telephone2.playRing()
    }
    printPageEnd(22)

    //SAYFA 37 DTO
    printPageStart(37)
    var book= BookDTO()
    with(book){
        bookName= "Kinyas ve Kayra"
        pages= 240
        description= "It is about two crazy guys' journey"
        println("This book is ${bookName}. It has ${pages} pages. ${description}")
    }
    printPageEnd(37)

    //SAYFA 38
    //DTO orneginde id, Person ve Singer classlarinda ise age ve money icin default parameter kullanilmistir
    printPageStart(38)
    val me=Person("Ece")
    println("Default parameter for my money is ${me.money}")
    printPageEnd(38)

    //SAYFA 39
    printPageStart(39)
    val hasMoney= family.filter{person -> person.money>0 }
    for (person in hasMoney) println("${person.name} has $${person.money}")
    printPageEnd(39)

    //SAYFA 40
    val shoppingList = mutableListOf("apple","banana","wet tissues")
    val market= mutableListOf("books", "paper", "banana", "wet tissues")
    val shoppingCart= mutableListOf<String>()

    printPageStart(40)
    println("Your shopping list consists of ${shoppingList}. "+
            "Market has ${market}")
    for(item in shoppingList){
        if(item in market){
            shoppingCart.add(item)
            market.remove(item)
        }
    }
    println("You bought ${shoppingCart} from the market. " +
            "There is ${market} left at the market")
    printPageEnd(40)

    //SAYFA 43
    printPageStart(43)
    val map= mapOf("Ece" to "Admin", "Emre" to "User", "Asli" to "Admin")
    for(user in map){
        print("I am ${user.key}. ")
        if(user.value == "Admin"){
            doAdminStuff()
        } else {
            doUserStuff()
        }
    }
    printPageEnd(43)

    //SAYFA 44
    printPageStart(44)
    val book1= BookDTO()
    with(book1){
        bookName= "Fleabag"
        pages= 300
        description= "It is about a crazy lady"
    }
    val bookAuthorMap= mapOf<BookDTO,String>(book to "Hakan Gunday", book1 to "Phoebe Waller Bridge")
    for ( (book,author) in bookAuthorMap ){
        println("${book.bookName} belongs to $author")
    }
    printPageEnd(44)

    //SAYFA 45 LAZY PROPERTY
    printPageStart(45)
    val dataFetcher= DataFetcher()

    println("Accessing data...")
    println(dataFetcher.data)
    println("Accessing data again...")
    println(dataFetcher.data)
    printPageEnd(45)

    //SAYFA 46 EXTENSION FUNCTIONS
    printPageStart(46)
    val str= "Ece12345fsFB34"
    println("String before removeNumbers(): $str")
    println("String after removeNumbers(): ${str.removeNumbers()}")
    printPageEnd(46)

    //SAYFA 47 SINGLETON
    printPageStart(47)
    MyMap.findLocation()
    MyMap.changeLocation()
    printPageEnd(47)

    //SAYFA 48 ABSTRACT
    printPageStart(48)
    val basketball= Basketball()
    with(basketball){
        play()
        score()
        dribble()
        score()
        end()
    }
    printPageEnd(48)

    //SAYFA 50 IF NOT NULL ELSE
    printPageStart(50)
    val nullableString: String? = "Hello"

    // if not null uppercase, else Default
    val result = nullableString?.uppercase() ?: "Default"

    println("Result: $result")
    printPageEnd(50)

    //SAYFA 52
    printPageStart(52)
    val animals: List<String?> = listOf(null, "penguin")
    val firstAnimal = animals.firstOrNull() ?: "empty"
    println(firstAnimal)
    printPageEnd(52)

    //SAYFA 53
    printPageStart(53)
    nullableString?.let { nonNullString ->
        println("String is not null: $nonNullString")
        println("String length: ${nonNullString.length}")
    }
    printPageEnd(53)

    //SAYFA 55
    printPageStart(55)
    println( "Stop means ${translateToTurkish("Stop")} in Turkish" )
    printPageEnd(55)

    //SAYFA 56 TRY CATCH
    printPageStart(56)
    val userInput = "123"
    try {
        val number = userInput.toInt()
        println("Parsed number: $number")
    } catch (e: NumberFormatException) {
        println("Error: Input is not a valid integer")
    }
    printPageEnd(56)

    //SAYFA 58 IF TO VAR
    printPageStart(58)
    val person= Person("Ece", 21)
    val status=if(person.age in 18..29) "Young Adult"
    else if(person.age> 30) "Adult"
    else "Other"

    println("${person.name} is a $status")
    printPageEnd(58)

    //SAYFA 59
    printPageStart(59)
    val size=4
    val intArray= createIntArray(size)
    println("Created array: ${intArray.joinToString(", ")}")
    printPageEnd(59)

    //SAYFA 60
    printPageStart(60)
    println("The page number is ${thePage()}")
    printPageEnd(60)

    //SAYFA 61
    printPageStart(61)
    println("This example has been done at page 48")
    printPageEnd(61)

    //SAYFA 62
    printPageStart(62)
    val newBook= BookDTO().apply {
        bookName= "New Book"
        pages= 100
        description="This was created by apply"
    }
    println(newBook)
    printPageEnd(62)

    //SAYFA 64
    printPageStart(64)
    val intList = listOf(1, 2, 3, 4, 5)
    println("Printing integers:")
    printItems(intList)

    val stringList = listOf("apple", "banana", "orange")
    println("\nPrinting strings:")
    printItems(stringList)
    printPageEnd(64)

    //SAYFA 65 ALSO
    printPageStart(65)
    val numList = mutableListOf(3, 6, 9)
    val doubledNums = numList
        .also {
            println("Original: $it")
        }
        .map { it * 2 }
        .also {
            println("Doubled: $it")
        }
    println("Final: $doubledNums")
    printPageEnd(65)

    //SAYFA 67
    printPageStart(67)
    talkToUser()
    talkToUser(msg="Merhaba", name= "Ece")
    printPageEnd(67)

    //SAYFA 68 INFIX FUNC
    printPageStart(68)
    println("2 to the power of 5 equals to ${2 power 5}")
    printPageEnd(68)

    //SAYFA 69
    printPageStart(69)
    val pixel1= Pixel(21,12)
    val pixel2= Pixel(32, 24)
    val sum= pixel1 + pixel2
    println("The sum of pixels is (${sum.x}, ${sum.y})")
    printPageEnd(69)

    //SAYFA 70
    printPageStart(70)
    printNums(10,9,8,7,6,5,4,3,2,1,0)
    println()
    printPageEnd(70)

    //SAYFA 84 DO WHILE
    printPageStart(84)
    var bikes= 20
    var bikesOnTheRack=0
    do{
        bikesOnTheRack++
        bikes--
    }while (bikes>0)
    println("There are $bikesOnTheRack bikes on the rack")
    printPageEnd(84)

    //SAYFA 88 EQUALITY CHECKS
    printPageStart(88)
    val celeb1= "Rihanna"
    val celeb2= "Rihanna"
    val celeb3= "Taylor"
    println("celeb1 == celeb2 : ${celeb1 == celeb2}")
    println("celeb2 == celeb3 : ${celeb2 == celeb3}")

    val green="green"
    val green2= "green"
    val green3= green
    println("green === green2 : ${green === green2}")
    println("green === green3 : ${green === green3}")
    printPageEnd(88)

}

//SAYFA 10 FUNCTIONS
/**
 *This function is to format the start of pages
 *
 * @param num page number
 */
fun printPageStart(num: Int){
    print("Sayfa $num= ")
}

/**
 *This function is to format the end of pages
 *
 * @param num page number
 */
fun printPageEnd(num: Int){
    println("""
====== end of page $num ======
    """)
}

/**
 * This function takes minutes and returns it as h and m
 *
 * @param min minutes
 * @return hours and minutes
 */
fun minsToHours(min:Int):String{
    return ("${min/60} hour(s) and ${min%60} min(s)")
}

/**
 * This function takes hours and returns it mins
 *
 * @param hour hours
 * @return minutes
 */
fun hoursToMins(hour: Int) = "${hour * 60} mins"

/**
 * This function prints minutes and h and m
 *
 * @param min minutes
 */
fun printMinsToHours(min:Int):Unit{
    println("$min minutes are ${minsToHours(min)}")
}

//SAYFA 12 CLASSES AND INSTANCES
class Device() {
    init {
        println("New device is created")
    }
    fun turnOn(){
        println("Device is turned on")
    }
    fun turnOff() {
        println("Device is turned off")
    }
}

class Telephone(ringtone:String= "La La ", ringtime: Int=2){
    val ring= ringtone.repeat(ringtime)
}
//same as Device but it is an open class
open class Device2() {
    init {
        println("New device is created")
    }
    open fun turnOn(){
        println("Device is turned on")
    }
    fun turnOff() {
        println("Device is turned off")
    }
}

class Telephone2(val ringtone:String= "La La ", val ringtime: Int=2): Device2() {
    var ring= ringtone.repeat(ringtime)

    fun playRing()= println(ring)

    override fun turnOn(){
        println("Telephone is turned on")
        playRing()
    }
}

//SAYFA 13
open class Person(val name: String, val age:Int= 0, var money:Int=0){
    fun sayName(){
        println("Hi my name is $name")
    }

    open fun doChore(chore:String){
        println("I am ${name} and I am responsible with: $chore")
    }

    open fun earnMoney(amount:Int){
        money += amount
    }
}

class Singer(name: String, age: Int=0, money: Int=0) : Person(name, age, money){
    fun sing(song:String){
        when(song.lowercase()){
            "rolling in the deep"-> println("## There is a fire starting in my heart ##")
            "someone like you"-> println("## Never mind, I'll find someone like you ##")
            else -> println("Sorry I don't know that song")
        }

    }
}

//SAYFA 15 KOSULLU IFADELER
//uzun gosterim
fun isEven(num: Int):String{
    return if(num%2==0) {
        "Number $num is even"
    } else{
        "Number $num is odd"
    }
}

//tek satirda yazilimi
fun isOdd(num:Int)= if(num%2==0) "Number $num is even" else  "Number $num is odd"

//SAYFA 17 WHILE DONGUSU
/**
 * This function makes all the members of a family say their name
 *
 * @param family A list of Person
 */
fun greetAll(family:List<Person>){
    var index= 0
    while(index<family.size){
        family[index].sayName()
        index++
    }
}

//SAYFA 37 DTO
data class BookDTO(var bookName: String, var pages:Int, var description: String, var bookId: Int=0){
    constructor(): this("",0,"")
}

//SAYFA 43
fun doAdminStuff(){
    println("I am doing admin stuff")
}

fun doUserStuff(){
    println("I am doing user stuff")
}

//SAYFA 45 LAZY PROPERTY
class DataFetcher{
    val data: List<String> by lazy{
        println("Loading data from database...")
        //data loading process
        //Thread.sleep(2000)
        listOf("Data1", "Data2")
    }
}

//SAYFA 46 EXTENSION FUNCTION
fun String.removeNumbers():String{
    return this.filter { !it.isDigit() }
}

//SAYFA 47 SINGLETON
object MyMap{
    init{
        println("Map is initialized")
    }

    fun findLocation(){
        println("You are right here [x]")
    }

    fun changeLocation(){
        println("Your location changed [!]")
    }
}

//SAYFA 48 ABSTRACT
abstract class Game{
    abstract var points:Int

    abstract fun play()
    abstract fun score()
    fun end(){
        println("The game has ended. Your score is ${points}")
    }
}

class Basketball(override var points: Int=0) : Game(){
    override fun play(){
        println("The basketball game has started.")
    }
    override fun score(){
        points += 3
        println("Basket! You have $points points.")
    }

    fun dribble(){
        println("Dribbling the basketball.")
    }
}

//SAYFA 55
fun translateToTurkish(word:String):String{
    return when(word.lowercase()){
        "stop" -> "Dur"
        "go" -> "Git"
        "stay" -> "Kal"
        else -> "I don't know"
    }
}

//SAYFA 59
fun createIntArray(size: Int): IntArray{
    return IntArray(size) { it+1}
}

//SAYFA 60
fun thePage() = 60

//SAYFA 64
inline fun <reified T> printItems(items: List<T>) {
    for (item in items) {
        var type= T::class.simpleName
        println("$item is type $type")
    }
}

//SAYFA 67
fun talkToUser(name: String="User", msg:String="Hello"){
    println("$msg $name")
}

//SAYFA 68 INFIX FUNC
infix fun Int.power(pow: Int): Int{
    if(pow==0) return 1
    else if(pow==1) return this
    else return this * this.power(pow-1)
}

//SAYFA 69
data class Pixel(val x:Int, val y:Int){
    operator fun plus(other: Pixel): Pixel{
        return Pixel(this.x + other.x, this.y + other.y)
    }
}

//SAYFA 70
fun printNums(vararg nums:Int){
    for(num in nums) print("$num ")
}