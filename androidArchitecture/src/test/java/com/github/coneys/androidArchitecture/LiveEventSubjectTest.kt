package com.github.coneys.androidArchitecture

import com.github.coneys.androidArchitecture.subject.LiveEventSubject


class LiveEventSubjectTest : LiveTest() {
    init {
        "On posting after listening, value should be there"{

            val subject = LiveEventSubject<String>()
            val test = subject.test()

            subject.post("abc")

            test.assertValue("abc")

        }

        "On posting before listening, value should not be there "{

            val subject = LiveEventSubject<String>()

            subject.post("abc")

            val test = subject.test()

            test.assertEmpty()

        }


    }
}

