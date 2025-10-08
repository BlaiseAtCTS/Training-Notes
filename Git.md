# Git Notes
git push -u origin main
origin - remote repo link
main - remote repo branch

## Should I set upstream for each new branch?
Yes, it is highly recommended to set the upstream for any local branch that you intend to share and collaborate on via the remote.

The -u Flag (or --set-upstream): If the upstream is already set, Git ignores the -u part. If you have run it once, you don't need to run it again for that branch.

git push origin songs
Even if you execute this from main branch, it will still only push the commited files in local songs branch.

local is ahead of remote (local log is ahead of remote log) -> direct push

remote is ahead of local (remote log is ahead of remote log) -> direct pull

latest local log is diff from latest remote log(merge conflict) -> git pull(merge conflict will be given in the file, you can edit it there -> this will cause you to create a new log, which will be ahead of both remote log & local log) -> so direct push