package leetcode.medium

import java.util.LinkedList

data class Employee (
    val id: Int = 0,
    val importance: Int = 0,
    val subordinates:List<Int> = listOf(),
)

class bfs {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val employeeMap = getEmployeeMap(employees.filterNotNull())
        var importance = 0
        val q = LinkedList<Employee>().apply { add(employeeMap[id]!!) }

        while (q.isNotEmpty()) {
            val employee = q.pop()
            importance += employee.importance
            employee.subordinates.map { subordinateId ->
                employeeMap[subordinateId]?.let { q.add(it) }
            }
        }

        return importance
    }

    private fun getEmployeeMap(employees: List<Employee>): Map<Int, Employee> {
        return employees.fold(mutableMapOf()) { acc, employee ->
            acc[employee.id] = employee
            acc
        }
    }
}

class dfs {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val employeeMap = getEmployeeMap(employees.filterNotNull())
        return getAllImportance(employeeMap, id)
    }

    private fun getEmployeeMap(employees: List<Employee>): Map<Int, Employee> {
        return employees.fold(mutableMapOf()) { acc, employee ->
            acc[employee.id] = employee
            acc
        }
    }

    private fun getAllImportance(
        employeeMap: Map<Int, Employee>,
        id: Int,
        importance: Int = 0,
    ): Int {
        val employee = employeeMap[id]
        return employee?.let {
            val acc = it.importance + importance
            it.subordinates.sumOf { subordinateId ->
                getAllImportance(employeeMap, subordinateId, acc)
            } + it.importance
        } ?: importance
    }
}
