import random
import random_bot

def script(check, x, y):
	if (check('level') == 1):
		if (not(check('wall', x+2, y))):
			if (check('player', x+1, y)):
				return 'pass'
			if (check('gold', x, y) > 0):
				return 'take'
			return 'right'
		elif(check('level') == 1): 
			if (check('gold', x, y) > 0):
				return 'take'
			return 'down'
	if (check('level') == 2):
		if (check('gold', x, y) > 0):
				return 'take'			
		if (not(check('wall', x+2, y))and not(check('gold', x, y-1)) and not(check('gold', x, y+1))):
			return 'right'
		elif(not(check('wall', x, y-1)) and not(check('gold', x, y+1)) and not(check('gold', x+1, y))):
			return 'up'
		elif(not(check('wall', x, y+1)) and not(check('gold', x+1, y))):
			return 'down'
		return 'right'

	if (check('level') == 3):
		if (check('gold', x, y) > 0):
			return 'take'
		if ((check('wall', x+1, y-1) and not (check('wall', x+1, y))) or (not check('wall', x+1, y) and (check('wall', x, y+1))) or (not check('wall', x+1, y) and check('wall', x, y-1))):
			return 'right'
		elif ((not check('wall', x, y-1) and (check('wall', x+1, y))) or (check('wall', x-1, y) and (not check('wall', x, y-1))) or (check('wall', x-1, y-1)) and not (check('wall', x, y-1))):
			return 'up'
		elif ((check('wall', x, y-1) and not check('wall', x, y+1))):
			return 'down'
		elif (not check('wall', x, y+1) and not check('wall', x, y-1) and not (check('wall', x-1, y)) and not(check('wall', x, y-1))):
			return 'left'

	


		


 


