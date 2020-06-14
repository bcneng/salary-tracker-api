package net.bcneng.salarytrackerbe.domain

import net.bcneng.salarytrackerbe.domain.graphql.CompanySize
import net.bcneng.salarytrackerbe.domain.graphql.EmploymentType
import net.bcneng.salarytrackerbe.domain.graphql.Gender
import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
data class Salary(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    val id: UUID? = null,
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

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "technologies_salary",
        joinColumns = [JoinColumn(name = "salary_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "technology_id", referencedColumnName = "id")])
    val technologies: Set<Technology>,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "perks_salary",
        joinColumns = [JoinColumn(name = "salary_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "perks_id", referencedColumnName = "id")])
    val perks: Set<Perk>
)

@Entity
data class Technology(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int,
    val value: String
)

@Entity
data class Perk(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int,
    val value: String
)
