package com.daelim.springtest.week05

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApiGraphqlPracticeTest {

    @Test
    fun graphqlMutationMemo() {
        val mutation = """
            mutation {
              createTest(userId:"1") {
                id
                address
                email
                tel
                age
              }
            }
        """.trimIndent()

        println("GraphQL Mutation 예시")
        println(mutation)
    }

    @Test
    fun graphqlQueryMemo() {
        val query = """
            query {
              findAllTests {
                id
                address
                email
                tel
                age
              }
              findTestById(id:"1") {
                id
                address
                email
                tel
                age
              }
            }
        """.trimIndent()

        println("GraphQL Query 예시")
        println(query)
    }

    @Test
    fun graphqlPracticeInfo() {
        println("GraphQL 실습")
        println("Mutation -> createTest(userId:\"1\")")
        println("Query -> findAllTests, findTestById(id:\"1\")")
        println("GraphiQL 주소 -> http://localhost:8080/graphiql.html")
    }
}