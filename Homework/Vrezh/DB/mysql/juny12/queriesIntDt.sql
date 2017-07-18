# | camera_name | fixed date | objects_count |

select name as camera_name, date , count(camera_id) as object_count from Traffic, Cameras where camera_id = name group by name, date order by name;


# | fixed date | image_url | camera data ... 

select date, image_url, Cameras.*  from Traffic, Cameras where camera_id = name and date="2017-07-09"  group by name, date order by name;
