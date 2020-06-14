package net.bcneng.salarytrackerbe.infrastructure.http.graphql

import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryFormDataResult
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryInput
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryResult
import net.bcneng.salarytrackerbe.infrastructure.db.SalaryEntryRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SalaryEntryQuery(val salaryEntryRepository: SalaryEntryRepository) : Query {
    fun getSalaryEntryFormData(): SalaryEntryFormDataResult = TODO() // salaryEntryRepository.findAll().toGraphQL()
    fun getAll() = salaryEntryRepository.findAll().toGraphQL()
    fun getById(id: String) = salaryEntryRepository
        .findById(UUID.fromString(id))
        .map { it.toGraphQL() }
        .orElseThrow { IllegalArgumentException("Not found") }
}

@Component
class SalaryEntryMutation(val salaryEntryRepository: SalaryEntryRepository) : Mutation {
    fun addSalaryEntry(input: SalaryEntryInput): SalaryEntryResult = salaryEntryRepository.save(input.toDB()).toResult()
}
