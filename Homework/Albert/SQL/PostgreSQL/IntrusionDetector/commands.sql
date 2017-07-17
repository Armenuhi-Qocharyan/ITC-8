--Ինչ որ օրվա օբյեկտների ցուցակը և համապատասխան կամեռաի տվյալները.
select images.detecteddate, images.detectedtime,images.imagespath,traffic.type, cameras.latitude, cameras.longitude from images  inner join traffic on  images.trafficid=traffic.id and images.detecteddate between '2017-05-05' and '2017-07-07' inner join cameras on images.camerasid=cameras.id order by images.detectedtime;

--Որ կամեռան որ որը քանի օբյեկտ ունի
select images.detecteddate, count(traffic.type) from images  inner join traffic on images.trafficid=traffic.id group by images.detecteddate order by count(traffic.type);
