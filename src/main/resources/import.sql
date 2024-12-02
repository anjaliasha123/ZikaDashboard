BEGIN;

--CREATE EXTENSION IF NOT EXISTS postgis;
--CREATE EXTENSION IF NOT EXISTS postgis_topology;
--CREATE EXTENSION IF NOT EXISTS fuzzystrmatch;
--CREATE EXTENSION IF NOT EXISTS postgis_tiger_geocoder;
--CREATE EXTENSION IF NOT EXISTS unaccent;
-- COPY occurrences() FROM '/tmp/report.csv' DELIMITER ',' CSV HEADER;
-- Step 1: Create a temporary table to load the CSV

-- Step 2: Load the CSV into the temporary table
COPY occurences(id, kingdom, phylum, class, family, scientific_name, genus, country, state_province, decimal_latitude, decimal_longitude) FROM '/tmp/filtered_occurrences.csv' DELIMITER ',' CSV HEADER;


-- Step 4: Drop the temporary table
--DROP TABLE temp_occurrences;

COMMIT;