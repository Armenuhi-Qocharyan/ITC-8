import Skype4Py
import sys
import rstr

def getMessage ():
    data = rstr.xeger(r'[A-Z]{1}[a-z]{5} [A-Z]{1}[a-z]{8}yan  \d{4}')
    Skype(data)

def Skype (data):
    skype = Skype4Py.Skype()
    skype.Attach()
    user = sys.argv[1]
    message = data
    skype.SendMessage(user, message)
getMessage()
