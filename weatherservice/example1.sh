
SLEEPBETWEEN=3

function executeCMD {
    echo -e "\n\n$MSG"
    $CMD
    sleep $SLEEPBETWEEN
}

MSG="Fetching all cities in memory"
CMD="curl -X GET http://localhost:8080/api/weather/cities"
executeCMD


MSG="Fetching maximum temperatures for a known city: Ostrava"
CMD="curl -X GET http://localhost:8080/api/weather/cities/ostrava/temperatures"
executeCMD

