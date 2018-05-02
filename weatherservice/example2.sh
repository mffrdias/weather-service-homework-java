
SLEEPBETWEEN=3

function executeCMD {
    echo -e "\n\n$MSG"
    echo -e "$CMD"
    $CMD
    sleep $SLEEPBETWEEN
}

MSG="Creating a new city called vilareal"
CMD="curl -X PUT http://localhost:8080/api/weather/cities?name=vilareal"
executeCMD


MSG="Fetching temperatures for: vilareal"
CMD="curl -X GET http://localhost:8080/api/weather/cities/vilareal/temperatures"
executeCMD

MSG="Fetching maximum temperatures for a UNknown city: porto"
CMD="curl -X GET http://localhost:8080/api/weather/cities/porto/temperatures"
executeCMD

