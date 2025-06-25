# Scenario 01 no transaction

### Run Project
Must follow those steps [Readme.md](README.md) in the section **Running locally**

### Database
Product (Table) must be without data

### Client HTTP makes request
Must follow those steps [Readme.md](README.md) in the section **Client HTTP test Request**

## Tested Scenarios

### Scenario 1: No Transactional, Product Not Found

- ❌ No @Transactional
- ✅ Product ID not present in DB
- ✅ Sale inserted
- ❌ Expected rollback → did NOT happen
