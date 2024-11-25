BEGIN;

CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS postgis_topology;
CREATE EXTENSION IF NOT EXISTS fuzzystrmatch;
CREATE EXTENSION IF NOT EXISTS postgis_tiger_geocoder;
CREATE EXTENSION IF NOT EXISTS unaccent;
-- COPY report() FROM '/tmp/report.csv' DELIMITER ',' CSV HEADER;
--Brazil_Zika-2016-04-02.csv
COPY report(reported_date, location, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location_geometry) from '/tmp/Brazil_Zika-2016-04-02.csv' DELIMITER ',' CSV HEADER;
COPY report(reported_date, location, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location_geometry) from '/tmp/Panama_Zika-2016-02-18.csv' DELIMITER ',' CSV HEADER;
COPY report(reported_date, location, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location_geometry) from '/tmp/Haiti_Zika-2016-02-03.csv' DELIMITER ',' CSV HEADER;
--COPY report(reported_date, location, location_type, data_field, data_field_code, time_period, time_period_type, value, unit, location_geometry) from '/tmp/MINSA_ZIKA_Search-Week_08.csv' DELIMITER ',' CSV HEADER;
COMMIT;