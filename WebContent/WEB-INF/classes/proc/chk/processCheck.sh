#!/bin/ksh

YYYYMMDD=`TZ=KST-9; date +%Y%m%d`
LOG_DATE=`TZ=KST-9; date +%Y.%m.%d`
LOG_TIME=`TZ=KST-9; date +%H:%M:%S`
LOG_DATETIME="$LOG_DATE $LOG_TIME"
CURL=/usr/local/bin/curl

LOGFILE="/log/feelring/process/$YYYYMMDD"
HOST="http://localhost"
URIs="$HOST/hangCheck.jsp"
TIMEOUT=180

RESULT_INFO=""
RESULT_ERROR=""

## netstat -an | grep "\.8009 " | grep "ESTABLISHED" | grep -v grep
## lsof -p 23222 | grep "TCP no TCP/UDP/IP information available"

hangCheck()
{
     RESULT_CODE=$?
     echo "[$LOG_DATETIME] INFO  at processCheck.Process Hang Check - [RESULT=$RESULT_CODE]" >> $LOGFILE

     if [ $RESULT_CODE -ne 0 ]
     then
         if [ $RESULT_CODE -eq 6 ]; then
             echo "[$LOG_DATETIME] ERROR at processCheck.Process Hang Check - Unable to resolve host [RESULT=$RESULT_CODE]" >> $LOGFILE
         fi

         if [ $RESULT_CODE -eq 7 ]; then
             echo "[$LOG_DATETIME] ERROR at processCheck.Process Hang Check - Unable to connect to host [RESULT=$RESULT_CODE]" >> $LOGFILE
         fi

         if [ $RESULT_CODE -eq 26 ]; then
             echo "[$LOG_DATETIME] ERROR at processCheck.Process Hang Check - Read error [RESULT=$RESULT_CODE]" >> $LOGFILE
         fi

         if [ $RESULT_CODE -eq 28 ]; then
             echo "[$LOG_DATETIME] ERROR at processCheck.Process Hang Check - Operation timeout $TIMEOUT sec [RESULT=$RESULT_CODE]" >> $LOGFILE
         fi

     else
         echo "[$LOG_DATETIME] INFO  at processCheck.Process Hang Check - Success [RESULT=$RESULT_CODE]" >> $LOGFILE
     fi
}

tomcatStatus()
{
    tcnt=`ps -ef | grep tomcat | grep -v grep | wc -l`

     if [ $tcnt -eq 1 ]
     then
        echo "[$LOG_DATETIME] INFO  at processCheck.Tomcat Multi Started Check - Success [COUNT=$tcnt]">> $LOGFILE
     else
         if [ $tcnt -eq 0 ]; then
             echo "[$LOG_DATETIME] ERROR at processCheck.Tomcat Multi Started Check - Tomcat Process not Running [COUNT=$tcnt]">> $LOGFILE
         fi
         if [ $tcnt -gt 1 ]; then
             echo "[$LOG_DATETIME] ERROR at processCheck.Tomcat Multi Started Check - Tomcat Multi Started [COUNT=$tcnt]">> $LOGFILE
         fi
     fi
}


echo "[$LOG_DATETIME] INFO  at processCheck START">> $LOGFILE

echo "[$LOG_DATETIME] INFO  at processCheck.Process Hang Check - Starting">> $LOGFILE

$CURL -s -o "/dev/null" -m $TIMEOUT $URIs
hangCheck;

echo "[$LOG_DATETIME] INFO  at processCheck.Process Hang Check - Finished">> $LOGFILE



echo "[$LOG_DATETIME] INFO  at processCheck.Tomcat Multi Started Check - Starting">> $LOGFILE

tomcatStatus;

echo "[$LOG_DATETIME] INFO  at processCheck.Tomcat Multi Started Check - Finished">> $LOGFILE


echo "[$LOG_DATETIME] INFO  at processCheck END">> $LOGFILE

