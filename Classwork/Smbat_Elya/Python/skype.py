from Skype4Py import Skype
import rstr
import time

client = Skype(Transport='x11')
client.Attach()
user = 'armenuhi_qocharyan_im'

while (True):
    message = rstr.xeger('[A-Z][a-z]{3,8} [A-Z][a-z]{3,8}yan (19\d\d|20[0-1][0-7])\nHi Armenuhi, you are resive message from Smbat :)')
    client.SendMessage(user, message)
    print message
    time.sleep(600)
