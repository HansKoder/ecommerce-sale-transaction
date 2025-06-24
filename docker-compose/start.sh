#!/bin/bash
docker-compose \
  -f docker-compose-sale-db.yml \
  -f docker-compose-liquibase.yml \
  -f docker-compose-sale-api.yml \
  up -d