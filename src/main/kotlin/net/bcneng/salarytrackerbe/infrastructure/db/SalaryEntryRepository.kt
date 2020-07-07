package net.bcneng.salarytrackerbe.infrastructure.db

import net.bcneng.salarytrackerbe.domain.Salary
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SalaryEntryRepository : CrudRepository<Salary, UUID>
