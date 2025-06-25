#!/bin/bash
docker-compose \
  -f docker-compose-sale-db.yml \
  -f docker-compose-liquibase.yml \
  down