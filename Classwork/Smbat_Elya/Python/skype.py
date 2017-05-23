from Skype4Py import Skype

client = Skype(Transport='x11')
client.Attach()
user = 'sgdk1987'
message = 'xxxxxxxxxxxxxxx'
client.SendMessage(user, message)
