#! /bin/bash


ECHO=`which echo`
DATE=`which date`
PWD=`which pwd`
PWDD=`$PWD`
TODAY=`$DATE +%Y%m%d`
BACKUPPATH="/app/ctas/patch/backup"
LOGPATH="/app/ctas/patch/log"
LOG="patch.$TODAY.log"
UNAME=`id -u -n`
if [ $UNAME != "ctas" ]
then
echo "Starting Failed !!  Use ctas account to start Patch ..." | tee -a $LOGPATH/$LOG

exit;
fi
if [ "$PWDD" = "/app/ctas/patch" ]
then
echo "*********************************************************************"

else
echo "Invalid Base Path : $PWDD " | tee -a $LOGPATH/$LOG

exit
fi
if [ "$TODAY" = "20160609" ]
then
echo "*********************************************************************"

else
echo "Check deploying date." | tee -a $LOGPATH/$LOG

echo "Deploying date is 20160609 " | tee -a $LOGPATH/$LOG

exit
fi
if [ "${0##*/}" = "deploy_src_20160609.sh" ]
then
echo "*********************************************************************"

else
echo "Shell Program is inValid. " | tee -a $LOGPATH/$LOG

echo "Check your shell Program and Patch File  and shell file name is deploy_src_20160609.sh and Deploying date is 20160609" | tee -a $LOGPATH/$LOG

exit
fi
if [ -f "./curation_admin_patch_20160609.zip" ]
then
echo "*********************************************************************"

else
echo "Patch File Not Found : curation_admin_patch_20160609.zip " | tee -a $LOGPATH/$LOG

exit
fi
echo "*********************************************************************" | tee -a $LOGPATH/$LOG

mkdir -pv $LOGPATH | tee -a $LOGPATH/$LOG
rm -fv $LOGPATH/$LOG | tee -a $LOGPATH/$LOG
mkdir -pv $BACKUPPATH | tee -a $LOGPATH/$LOG
rm -v $BACKUPPATH/curation_admin.backup.$TODAY | tee -a $LOGPATH/$LOG


echo "*********************************************************************" | tee -a $LOGPATH/$LOG

echo "backup start" | tee -a $LOGPATH/$LOG

sleep 2 

tar czf $BACKUPPATH/curation_admin.backup.$TODAY /app/ctas/webroot | tee -a $LOGPATH/$LOG


echo "backup end" | tee -a $LOGPATH/$LOG

sleep 2 

echo "*********************************************************************"  | tee -a $LOGPATH/$LOG

echo "Unzipcompress.........."  | tee -a $LOGPATH/$LOG 
unzip -d curation_admin_patch_20160609 curation_admin_patch_20160609.zip | tee -a $LOGPATH/$LOG

sleep 2 

echo "*********************************************************************"  | tee -a $LOGPATH/$LOG 


echo "Patch Start"  | tee -a $LOGPATH/$LOG 

echo "*********************************************************************" | tee -a $LOGPATH/$LOG

mkdir -p /app/ctas/webroot/WEB-INF/lib | tee -a $LOGPATH/$LOG

echo "*********************************************************************"  | tee -a $LOGPATH/$LOG
mkdir -p /app/ctas/webroot/WEB-INF/classes/sqlmap/mappers | tee -a $LOGPATH/$LOG
cp -rfv ./curation_admin_patch_20160609/channel_sql.xml  /app/ctas/webroot/WEB-INF/classes/sqlmap/mappers/ | tee -a $LOGPATH/$LOG
mkdir -p /app/ctas/webroot/WEB-INF/view/channel | tee -a $LOGPATH/$LOG
cp -rfv ./curation_admin_patch_20160609/youtube_reg.jsp  /app/ctas/webroot/WEB-INF/view/channel/ | tee -a $LOGPATH/$LOG
mkdir -p /app/ctas/webroot/WEB-INF/classes/kr/co/wincom/curation/client/controller | tee -a $LOGPATH/$LOG
cp -rfv ./curation_admin_patch_20160609/ChannelController.class    /app/ctas/webroot/WEB-INF/classes/kr/co/wincom/curation/client/controller/ | tee -a $LOGPATH/$LOG
cp -rfv ./curation_admin_patch_20160609/ChannelController"$"*.class  /app/ctas/webroot/WEB-INF/classes/kr/co/wincom/curation/client/controller/ | tee -a $LOGPATH/$LOG
cp -rfv ./curation_admin_patch_20160609/program_topchannel.jsp  /app/ctas/webroot/WEB-INF/view/channel/ | tee -a $LOGPATH/$LOG

echo "Patch End..............."  | tee -a $LOGPATH/$LOG

echo "*********************************************************************"  | tee -a $LOGPATH/$LOG

echo "Last processing..... "   | tee -a $LOGPATH/$LOG
rm -rf curation_admin_patch_20160609 | tee -a $LOGPATH/$LOG
mv -f curation_admin_patch_20160609.zip $BACKUPPATH/curation_admin_patch_20160609.zip.bak | tee -a $LOGPATH/$LOG
mv -f deploy_src_20160609.sh $BACKUPPATH/deploy_src_20160609.sh.bak | tee -a $LOGPATH/$LOG

echo "*********************************************************************"  | tee -a $LOGPATH/$LOG

sleep 2 
echo "Required !! Configuration File(curation_admin.properties, errorcode.properties, 
curation_admin_ext.properties, logback.xml, jar etc) Check!!"   | tee -a $LOGPATH/$LOG
