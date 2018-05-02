
SLEEPBETWEEN=3

function executeCMD {
    echo -e "\n\n$MSG"
    $CMD
    sleep $SLEEPBETWEEN
}

MSG="Adding a new maximum temperature to Brno"
CMD="curl -X POST http://localhost:8080/api/weather/cities/brno/temperatures?date=2018-05-01&temperature=25"
executeCMD


MSG="Trying to add again the same temperature for Brno..."
CMD="curl -X POST http://localhost:8080/api/weather/cities/brno/temperatures?date=2018-05-01&temperature=25"
executeCMD

MSG="Fetching temperatures for Brno"
CMD="curl -X GET http://localhost:8080/api/weather/cities/brno/temperatures"
executeCMD

