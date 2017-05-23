from Skype4Py import Skype
from random import randint
import rstr, time

while(1):
    person=rstr.xeger(r'[A-Z][a-z]{3} [A-Z][a-z]{4}yan 19[4-9][0-9]|200[0-9]|201[0-7]')
    print person
    client = Skype()
    client.Attach()
    client.SendMessage("skype", person)
    time.sleep(600)
