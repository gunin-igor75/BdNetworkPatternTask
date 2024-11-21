package com.github.gunin_igor75.bdnetworkpatterntask.example4

interface Transport {
    fun moving()
}

interface TransportFactory {
    fun createCar(): Transport
}

data class Car private constructor(
    val engine: Engine,
    val body: Body,
    val wheel: Wheel,
) : Transport {
    class Builder {
        private var _engine: Engine? = null
        private val engine: Engine
            get() = _engine ?: throw IllegalStateException("Engine field must be initialized")
        private var _body: Body? = null
        private val body: Body
            get() = _body ?: throw IllegalStateException("Body field must be initialized")
        private var _wheel: Wheel? = null
        private val wheel: Wheel
            get() = _wheel ?: throw IllegalStateException("Wheel field must be initialized")

        fun setEngine(engine: Engine): Builder {
            this._engine = engine
            return this
        }

        fun setBody(body: Body): Builder {
            this._body = body
            return this
        }

        fun setWheel(wheel: Wheel): Builder {
            this._wheel = wheel
            return this
        }

        fun build(): Car {
            return Car(engine, body, wheel)
        }
    }

    override fun moving() {
        println("$this moving")
    }

    companion object Factory : TransportFactory {
        override fun createCar(): Transport {
            return Car.Builder()
                .setEngine(Engine(1000))
                .setBody(Body(("mazda")))
                .setWheel(Wheel(4))
                .build()
        }
    }
}


data class Engine(
    val power: Int,
)

data class Body(
    val type: String,
)

data class Wheel(
    val amount: Int,
)

fun main() {
    val factorYCar = Car.Factory
    val defaultCar = factorYCar.createCar()
    defaultCar.moving()
}