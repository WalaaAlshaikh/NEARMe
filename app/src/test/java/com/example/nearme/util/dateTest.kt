package com.example.nearme.util

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class dateTest {

    private lateinit var validate:util

    @Before
    fun setUp()
    {
        validate=util()
    }

    @Test
    fun convert() {
        val validator=validate.convert("2021-05-11 12:06:10")
        assertEquals("2021-05-11T12:06:10",validator.toString())


    }

    @Test
    fun convertlong() {

        val validator=validate.convertlong(1620723972L)
        assertEquals("2021-05-11T12:06:12",validator.toString())


    }
}