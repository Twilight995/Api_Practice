package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.BoardDto
import com.daelim.springtest.main.api.model.dto.TestDto
import com.daelim.springtest.main.api.model.dto.TestDtoRequest
import net.datafaker.Faker
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class Controller {

    private val tests = mutableListOf<TestDto>()
    private val boards = mutableListOf<BoardDto>()



    @PostMapping("/test")
    fun postTestDto(
        @RequestBody testDtoRequest: TestDtoRequest
    ): ResponseEntity<TestDto> {
        val faker = Faker(Locale.KOREA)
        val test = TestDto(
            id = testDtoRequest.id,
            address = faker.address().fullAddress(),
            email = faker.internet().emailAddress(),
            tel = faker.phoneNumber().phoneNumber(),
            age = Random().nextInt(100)
        )
        tests.add(test)
        return ResponseEntity.ok().body(test)
    }

    @GetMapping("/test")
    fun getAllTestDto(): ResponseEntity<List<TestDto>> {
        return ResponseEntity.ok().body(tests)
    }

    @GetMapping("/test/{id}")
    fun getTestDto(
        @PathVariable("id") userId: String
    ): ResponseEntity<TestDto> {
        val response = tests.firstOrNull { it.id == userId }
        return ResponseEntity.ok().body(response)
    }

    @DeleteMapping("/test/{id}")
    fun deleteTestDto(
        @PathVariable("id") userId: String
    ): ResponseEntity<List<TestDto>> {
        tests.removeIf { it.id == userId }
        return ResponseEntity.ok().body(tests)
    }

    @PostMapping("/board")
    fun createBoard(
        @RequestBody boardDto: BoardDto
    ): ResponseEntity<BoardDto> {
        boards.add(boardDto)
        return ResponseEntity.ok().body(boardDto)
    }

    @GetMapping("/board")
    fun getAllBoards(): ResponseEntity<List<BoardDto>> {
        return ResponseEntity.ok().body(boards)
    }
}