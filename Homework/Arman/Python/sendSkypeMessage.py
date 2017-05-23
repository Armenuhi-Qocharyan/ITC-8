from Skype4Py import Skype
from random import randint
import rstr, time

while(1):
    person=rstr.xeger(r'[A-Z][a-z]{3} [A-Z][a-z]{4}yan ')
    person+=str(randint(1940, 2017))
    print person
    client = Skype()
    client.Attach()
    client.SendMessage("armenuhi_qocharyan_im", person)
    time.sleep(600)
