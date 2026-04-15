package com.daelim.springtest

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.datafaker.Faker
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class CoroutineQuiz {

    @Test
    fun testDataFaker(){
        val faker = Faker(Locale.KOREA)
        println(faker.name().name())
    }

    /*
        100명의 가상 사용자 이름을 로그로 출력하세요
    */
    @Test
    fun quiz1Test(){
        val faker = Faker(Locale.KOREA)
        repeat(100) { i ->
            println("${i + 1}. ${faker.name().name()}")
        }
    }

    /*
        50명의 가상 사용자의 이름, 이메일, 주소를 로그 출력하세요
     */
    @Test
    fun quiz2Test(){
        val faker = Faker(Locale.KOREA)
        repeat(50) { i ->
            val name = faker.name().name()
            val email = faker.internet().emailAddress()
            val address = faker.address().fullAddress()
            println("${i + 1}. 이름: $name | 이메일: $email | 주소: $address")
        }
    }

    /*
        30명의 가상 사용자의 이름과 나이 생성를 데이터클래스로 생성하고, 어린 나이 순으로 정렬 후 출력하세요
     */
    data class User(val name: String, val age: Int)

    @Test
    fun generateSortAndPrintUserAges() {
        val faker = Faker(Locale.KOREA)
        val users = List(30) {
            User(
                name = faker.name().name(),
                age = faker.number().numberBetween(1, 100)
            )
        }
        val sorted = users.sortedBy { it.age }
        sorted.forEachIndexed { i, user ->
            println("${i + 1}. 이름: ${user.name} | 나이: ${user.age}")
        }
    }
}