#install skype4py
#install rstr

from Skype4Py import Skype
import rstr
import time

client = Skype(Transport='x11')
client.Attach()
user = 'albert93aghajanyan'

while (1):
    #message = rstr.xeger('[A-Z][a-z]{1,5} [A-Z][a-z]{1,5}yan (19\d\d|20[0-1][0-7])')
    
    message = rstr.xeger('[A-Z][a-z]{3,5} [A-Z][a-z]{4,6}yan (19\d[5-9])')
    client.SendMessage(user, message)
    time.sleep(600)
