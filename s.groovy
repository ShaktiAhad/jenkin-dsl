def folder(dslScript, folders) {
    print "inside createfolders"

    jobDsl targets: dslScript, additionalParameters: [folders: folders]
}
return this