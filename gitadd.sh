read -p "Enter commit message : " message
echo "=============================================================="
echo "  		STATUS of current modifications"
echo "=============================================================="
git status
echo "=============================================================="
echo "  			Adding everything"
echo "=============================================================="
git add *
echo "=============================================================="
echo "  		Commiting with message Leetcode Prep"
echo "=============================================================="
git commit -m "$message"
read -p "Do you want to push to origin? " confirmPush
if [ -z "$confirmPush"]
then
	 git push -u origin master
elif [$confirmPush == "Y" || $confirmPush == "y"]
then
	git push -u origin master
fi
