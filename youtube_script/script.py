import os
import sys
import subprocess

def runDownloader(downloadLinks):
	fp = open(downloadLinks, "rt")
	contents = fp.readlines()
	fp.close()
	print "hoola"
	for link in contents:
		command = "youtube-dl " + link + " --verbose --extract-audio --audio-format mp3 --write-sub"
		subprocess.call(command.split(" "))

runDownloader("links.txt")
