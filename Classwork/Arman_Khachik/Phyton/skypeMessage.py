#You must install rstr and Skype4Py

from Skype4Py import Skype
import sys
import rstr

message = rstr.xeger('[A-Z][a-z]{4} [A-Z][a-z]{3,6}yan  \d{4}')

client = Skype()
client.Attach()
user = "armenuhi_qocharyan_im" 
message = man
client.SendMessage(user, message)
