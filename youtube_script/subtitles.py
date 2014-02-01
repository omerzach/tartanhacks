import os

def timing(timestamp):
	split = timestamp.split(':')
	hours = int(split[0].strip())
	minutes = int(split[1].strip())
	seconds = int(split[2].split(',')[0].strip())
	milliseconds = int(split[2].split(',')[1].strip())
	return hours, minutes, seconds, milliseconds
	

def processSubsection(lines, lineNumber):
	section = int(lines[lineNumber -1].strip())
	index = lineNumber + 1
	subtitle = ""
	while True:
		if (lines[index].strip() == ''):
			break;
		subtitle = subtitle + " %s "  % (lines[index].strip())
		index += 1
	if ('[Applause]' in subtitle):
		return
	if ('--' in subtitle):
		subtitle = subtitle.replace("--", "")
	

	timings = []
	timings.append(timing(lines[lineNumber].split(' --> ')[0].strip()))
	
	timings.append(timing(lines[lineNumber].split(' --> ')[1].strip()))
	print section, subtitle, timings
	return
		
		
		
def processSubtitle(subtitleVideo):
	fp = open(subtitleVideo, "rt")
	lines = fp.readlines()
	fp.close()

	for i in xrange(len(lines)):
		if '-->' in lines[i]:
			processSubsection(lines, i)


def run():
	path = ""
	for filename in os.listdir(os.getcwd()):
		if "en.srt" in filename:
			processSubtitle(filename)

run()
