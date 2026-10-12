package com.example.tenantmanagementsystem

object TenantRepository {
    // One list shared by the whole app
    val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    // Adds up all rents; text that isn't a number counts as 0.0
    fun totalRent(): Double {
        return tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
    }
}