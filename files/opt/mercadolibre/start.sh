#!/bin/bash
#
# DESCRIPTION:                          Script to deploy country services
#
#
# PLATFORMS:                            Linux
#
# INPUT PARAMETERS:                     
#
# OUTPUT PARAMETERS                     docker services
#
#
# AUTHOR                                        Dufresny Ovalle
#
# DATE LAST MODIFICATION:       30/03/2020
#
# USAGE:                                        ./start.sh
#
# NOTES:

cd /opt/mercadolibre/blacklist
docker build -t ip-blacklist .
docker-compose up -d

echo "finished: ***********************************************************************************"
echo "finished: ***********************************************************************************"

sleep 2
cd /opt/mercadolibre/api-gateway
docker build -t api-gateway .
docker-compose up -d

echo "finished: ***********************************************************************************"
echo "finished: ***********************************************************************************"

sleep 2
cd /opt/mercadolibre/ipfinformation
docker build -t ipfinformation .
docker-compose up -d
