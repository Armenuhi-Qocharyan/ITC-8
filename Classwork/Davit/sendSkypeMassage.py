from Skype4Py import Skype
import sys
import time
import re 

def validation(string):
    while (1):
        if not re.match("^[A-Z][a-z]{2,15} [A-Z][a-z]{2,25} \d{4}.\d{2}.\d{2}", string):
            print('is incorrect')
        else:
            client = Skype(Transport ='x11')
            client.Attach()
            user = 'armenuhi_qocharyan_im'
            massage = 'string - Davit Sakanyan'
            client.SendMessage(user, massage)
            print('is correct')
        time.sleep(600)
        return

person = raw_input("Input about a person(Name Surname xxxx.xx.xx): ")
print "..........................."
validation(person)












