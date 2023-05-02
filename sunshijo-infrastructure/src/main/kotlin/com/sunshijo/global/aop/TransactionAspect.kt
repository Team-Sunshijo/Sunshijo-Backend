package com.sunshijo.global.aop

import org.aspectj.lang.annotation.Aspect
import org.springframework.aop.Advisor
import org.springframework.aop.aspectj.AspectJExpressionPointcut
import org.springframework.aop.support.DefaultPointcutAdvisor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.TransactionManager
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource
import org.springframework.transaction.interceptor.RollbackRuleAttribute
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute
import org.springframework.transaction.interceptor.TransactionInterceptor

@Configuration
@Aspect
class TransactionAspect (
        private val transactionManager: TransactionManager
) {

    @Bean
    fun transactionAdviceAdvisor(): Advisor {

        val pointcut = AspectJExpressionPointcut()
        pointcut.expression = "@within(com.sunshijo.annotation.UseCase)"

        return DefaultPointcutAdvisor(pointcut, transactionAdvice())
    }

    @Bean
    fun transactionAdvice(): TransactionInterceptor {

        val source = MatchAlwaysTransactionAttributeSource()
        val transactionAttribute = RuleBasedTransactionAttribute()

        transactionAttribute.setName("Transaction")
        transactionAttribute.rollbackRules = listOf(
                RollbackRuleAttribute(Exception::class.java)
        )
        source.setTransactionAttribute(transactionAttribute)

        return TransactionInterceptor(transactionManager, source)
    }
}