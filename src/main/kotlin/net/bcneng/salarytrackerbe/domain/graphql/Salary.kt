package net.bcneng.salarytrackerbe.domain.graphql

data class SalaryEntryFormDataResult(
    val position: List<String>,
    val technologies: List<String>,
    val perks: List<String>,
    val role: List<String>
)

data class SalaryEntryInput(
    val yearsInPosition: Int,
    val yearsInTotal: Int,
    val position: String,
    val role: String,
    val employmentType: EmploymentType,
    val companySize: CompanySize,
    val grossAnnualSalary: Int,
    val location: String,
    val gender: Gender,
    val remote: Boolean,
    val hoursPerWeek: Double,
    val technologies: List<String>,
    val perks: List<String>
)

data class SalaryEntry(
    val id: String,
    val yearsInPosition: Int,
    val yearsInTotal: Int,
    val position: String,
    val role: String,
    val employmentType: EmploymentType,
    val companySize: CompanySize,
    val grossAnnualSalary: Int,
    val location: String,
    val gender: Gender,
    val remote: Boolean,
    val hoursPerWeek: Double,
    val technologies: List<String>,
    val perks: List<String>
)

enum class EmploymentType(val value: Int) {
    CONTRACTOR(0),
    FREELANCE(1),
    EMPLOYEE(2)
}

enum class CompanySize(val value: Int) {
    ZERO_TO_TEN(0),
    TEN_TO_FIFTY(1),
    FIFTY_TO_INFINITY(2)
}

enum class Gender(val value: Int) {
    MALE(0),
    FEMALE(1),
    OTHER(2)
}

sealed class SalaryEntryResult
data class SalaryEntrySuccess(val id: String) : SalaryEntryResult()
data class ValidationError(val fields: List<String>) : SalaryEntryResult()
