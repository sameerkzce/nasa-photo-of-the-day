# nasa-photo-of-the-day
NASA photo of the day - It is sample demo Android App using Kotlin.<br />
API EndPoint-https://api.nasa.gov/ <br />
This demo Android App which uses Androidx,Kotlin,Glide,MVVM using Clean architecture.<br />

Description<br />
Once App lunch it will call API https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY, in response it might the Photo or Video link,
If it is photo then user can click on Fab button to open in next full screen or redirect to youtube app for video play using intent.  <br/>
 
 Request:<br/>
 https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY <br/>
 https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=2020-06-01 <br/>
 
 Response:<br/>
 {"copyright":"Bryan Goff","date":"2020-07-06","explanation":"Unspeakable beauty and unimaginable bedlam can be found together in the Orion Nebula Arguably the most famous of all astronomy nebulas, the Great Nebula in Orion is an immense interstellar molecular cloud only 1500 light-years away.  In the featured deep image shown in assigned colors, the part of the nebula's center known as M43 is shown as taken by the Hubble Space Telescope. The Great Nebula in Orion can be found with the unaided eye near the easily identifiable belt of three stars in the popular constellation Orion.  The entire Orion Nebula, including both M42 and M43 spans about 40 light years and is located in the same spiral arm of our Galaxy as the Sun.","hdurl":"https://apod.nasa.gov/apod/image/2007/M43_HubbleGoff_4000.jpg","media_type":"image","service_version":"v1","title":"M43: Dust, Gas, and Stars in the Orion Nebula","url":"https://apod.nasa.gov/apod/image/2007/M43_HubbleGoff_960.jpg"}
