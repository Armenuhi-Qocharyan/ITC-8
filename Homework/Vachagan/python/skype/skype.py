import Skype4Py
import sys
import rstr
import time

skype = Skype4Py.Skype()
skype.Attach()
user="skype"
#user = sys.argv[1]
#message = ' '.join(sys.argv[2:])

while 1==1:
    message = rstr.xeger('[A-Z][a-z]{3,5} [A-Z][a-z]{4,9}yan 1[7-9]{3}/[1-12]/[1-31]')
    skype.SendMessage(user, message)
    time.sleep(1000)
