package net.bcneng.salarytrackerbe.infrastructure.http.graphql

import net.bcneng.salarytrackerbe.domain.Perk
import net.bcneng.salarytrackerbe.domain.Salary
import net.bcneng.salarytrackerbe.domain.Technology
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntry
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryInput
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntryResult
import net.bcneng.salarytrackerbe.domain.graphql.SalaryEntrySuccess

fun SalaryEntryInput.toDB(): Salary = Salary(
    yearsInPosition = yearsInPosition,
    yearsInTotal = yearsInTotal,
    position = position,
    role = role,
    employmentType = employmentType,
    companySize = companySize,
    grossAnnualSalary = grossAnnualSalary,
    location = location,
    gender = gender,
    remote = remote,
    hoursPerWeek = hoursPerWeek,
    technologies = technologies.map { Technology(0, it) }.toSet(),
    perks = perks.map { Perk(0, it) }.toSet()
)

fun Salary.toGraphQL() = SalaryEntry(
    id = id.toString(),
    yearsInPosition = yearsInPosition,
    yearsInTotal = yearsInTotal,
    position = position,
    role = role,
    employmentType = employmentType,
    companySize = companySize,
    grossAnnualSalary = grossAnnualSalary,
    location = location,
    gender = gender,
    remote = remote,
    hoursPerWeek = hoursPerWeek,
    technologies = technologies.map { it.value },
    perks = perks.map { it.value }
)

fun Iterable<Salary>.toGraphQL() = map { it.toGraphQL() }
fun Salary.toResult(): SalaryEntryResult = SalaryEntrySuccess(this.id.toString())