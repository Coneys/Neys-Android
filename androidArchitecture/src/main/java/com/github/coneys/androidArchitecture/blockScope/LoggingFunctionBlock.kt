package com.github.coneys.androidArchitecture.blockScope

class LoggingFunctionBlock(val logger: FunctionBlockScopeLogger = FunctionBlockScopeLogger()) : FunctionBlockScope() {

    override fun skipFunction(tag: String) {
        super.skipFunction(tag)
        logger.skipped(tag)
    }

    override fun executeFunction(lambda: () -> Unit, tag: String) {
        super.executeFunction(lambda, tag)
        logger.executed(tag)
    }
}
