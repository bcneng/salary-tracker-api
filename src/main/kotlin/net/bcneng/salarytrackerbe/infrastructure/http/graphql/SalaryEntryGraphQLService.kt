package net.bcneng.salarytrackerbe.infrastructure.http.graphql

import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryFormDataResult
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryInput
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryResult
import org.springframework.stereotype.Component

@Component
class SalaryEntryQuery : Query {
    fun getSalaryEntryFormData(): SalaryEntryFormDataResult {
        TODO("Not yet implemented")
    }
}

@Component
class SalaryEntryMutation : Mutation {
    fun addSalaryEntry(input: SalaryEntryInput): SalaryEntryResult {
        TODO()
    }
}
