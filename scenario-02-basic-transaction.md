# Scenario 02 basic transaction

### Run Project
Must follow those steps [Readme.md](README.md) in the section **Running locally**

### Database
Product (Table) must be without data

### Client HTTP makes request
Must follow those steps [Readme.md](README.md) in the section **Client HTTP test Request**

## Tested Scenarios

#### Scenario 2: Transactional, Product Not Found

- ✅ @Transactional added to service
- ✅ Product ID not present in DB
- ✅ Sale NOT inserted (rollback successful)
- ✅ Stock NOT updated (rollback successful)